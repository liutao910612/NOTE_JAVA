package com.kevin.note.java.data.structure.string.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * AC自动机示例
 *
 * @Author:Kevin
 * @Date:Created in 15:57 2021/4/8
 */
public class Ac {

    private AcNode root = new AcNode('/');  //存储无意义字符

    /**
     * 构建失败指针
     */
    public void buildFailurePointer() {
        Queue<AcNode> queue = new LinkedList<>();
        root.fail = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            AcNode p = queue.remove();
            for (int i = 0; i < 26; i++) {
                AcNode pc = p.children[i];
                if (pc == null) {
                    continue;
                }

                /**
                 * 如果当前节点pc的父节点p为root,说明当前节点的父节点为其实节点，其失败指针只能指向root节点
                 */
                if (p == root) {
                    pc.fail = root;
                } else {
                    AcNode q = p.fail;
                    while (q != null) {
                        AcNode qc = q.children[pc.data - 'a'];
                        if (qc != null) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }

    public void match(char[] text) {  //text是主串
        int n = text.length;
        AcNode p = root;
        for (int i = 0; i < n; i++) {
            int idx = text[i] - 'a';
            while (p.children[idx] == null && p != root) {
                p = p.fail; // 失败指针发挥作用的地方
            }

            p = p.children[idx];
            if (p == null) {
                p = root; // 如果没有匹配的，从root开始重新匹配
            }

            AcNode tmp = p;
            while (tmp != root) {  //打印出可以匹配的模式串
                if (tmp.isEndingChar == true) {
                    int pos = i - tmp.length + 1;
                    System.out.println("匹配起始下标" + pos + "; 长度" + tmp.length);
                }
                tmp = tmp.fail;
            }

        }

    }

    static class AcNode {
        public char data;
        public AcNode[] children = new AcNode[26];  //字符集只包含a~z这26个字符
        public boolean isEndingChar = false;  //结尾字符为true
        public int length = -1; //当isEndingChar = true时，记录模式字符串的长度
        public AcNode fail; //失败指针

        public AcNode(char data) {
            this.data = data;
        }
    }
}
