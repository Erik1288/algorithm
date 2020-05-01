package com.eric.model.graph;

import java.util.List;

/**
 * User: Eric
 * Date: 2020/2/3
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
