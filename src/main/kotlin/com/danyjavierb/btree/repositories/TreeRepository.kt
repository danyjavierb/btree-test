package com.danyjavierb.btree.repositories

import com.danyjavierb.btree.models.BTree
import org.springframework.stereotype.Component


@Component
class TreeRepository {

    lateinit var tree: BTree

    fun createTree(elements:ArrayList<Int>){
        tree = BTree()
        elements.forEach {
            tree.root = tree.insert(tree.root, it)
        }
    }

    fun getLCA(a:Int,b:Int): Int? {
        return tree.findLCA(a,b)
    }

}