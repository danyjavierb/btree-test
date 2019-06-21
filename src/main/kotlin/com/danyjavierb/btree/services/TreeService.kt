package com.danyjavierb.btree.services

import com.danyjavierb.btree.models.Node
import com.danyjavierb.btree.repositories.TreeRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class TreeService {
    private val logger = LoggerFactory.getLogger(TreeService::class.java)

    @Autowired
    lateinit var repository: TreeRepository

    fun createBTree (elements : ArrayList<Int>){

        logger.info("Creating tree with data $elements")

        repository.createTree(elements)

        logger.info("Finish tree with data $elements")
    }

    fun getLCA (a: Int,b:Int):Int?{

        logger.info("getting lca with data $a ,$b")

       return  repository.getLCA(a,b)

    }
}