package com.kevin.note.java.data.structure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图示例
 *
 * @Author:Kevin
 * @Date:Created in 21:38 2021/3/30
 */
public class Graph {
    private int v;//顶点的个数
    private LinkedList<Integer> adj[];  //邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {//无向图，一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先算法
     *
     * @param s 起始点
     * @param t 终止点
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }

        boolean[] visited = new boolean[v]; //已经被访问的顶点
        visited[s] = true;

        Queue<Integer> queue = new LinkedList<>();  //保存已经访问过的，但是与其相连的顶点还没有被访问
        queue.add(s);

        int[] prev = new int[v]; //用来记录搜索路径
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            int w = queue.poll();
            for (int q : adj[w]) {
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                }
                visited[q] = true;
                queue.add(q);
            }
        }
    }

    boolean found = false;

    /**
     * 深度优先算法
     *
     * @param s 起始点
     * @param t 终止点
     */
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];

        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) {
            return;
        }

        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }

        for (int q : adj[w]) {
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    /**
     * 递归打印s -> t的路径
     *
     * @param prev
     * @param s
     * @param t
     */
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.println(t + "");
    }
}
