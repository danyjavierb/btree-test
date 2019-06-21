package com.danyjavierb.btree.models

data class Node(var key: Int) {
    var left: Node?=null
    var right: Node?=null
    var parent: Node? = null
}

