package com.kevin.note.java.data.structure.graph;

import java.util.LinkedList;

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
}
