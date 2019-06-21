package com.danyjavierb.btree.models
import java.util.ArrayList

class BTree {

    var root: Node? = null
    private val path1 = ArrayList<Int>()
    private val path2 = ArrayList<Int>()

    fun insert(node: Node?, key: Int): Node {
        if (node == null)
            return Node(key)

        if (key < node.key) {
            node.left = insert(node!!.left, key)
            node.left!!.parent = node
        } else if (key > node!!.key) {
            node.right = insert(node!!.right, key)
            node.right!!.parent = node
        }
        return node
    }

    fun findLCA(n1: Int, n2: Int): Int {
        path1.clear()
        path2.clear()
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            return -1
        }

        var i = 0
        while (i < path1.size && i < path2.size) {
            if (path1[i] != path2[i])
                break
            i++
        }

        return path1[i - 1]
    }

    private fun findPath(root: Node?, n: Int, path: MutableList<Int>): Boolean {

        if (root == null) {
            return false
        }

        path.add(root.key)

        if (root.key == n) {
            return true
        }

        if (root.left != null && findPath(root.left, n, path)) {
            return true
        }

        if (root.right != null && findPath(root.right, n, path)) {
            return true
        }

        path.removeAt(path.size - 1)

        return false
    }

} 