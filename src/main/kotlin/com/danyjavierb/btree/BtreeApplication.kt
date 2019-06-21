package com.danyjavierb.btree

import com.danyjavierb.btree.models.BTree
import com.danyjavierb.btree.models.Node
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BtreeApplication

fun main(args: Array<String>) {
    runApplication<BtreeApplication>(*args)
}
