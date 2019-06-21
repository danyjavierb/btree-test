package com.danyjavierb.btree.controllers

import com.danyjavierb.btree.router.Router
import com.danyjavierb.btree.router.Router.Companion.BASE_PATH
import com.danyjavierb.btree.services.TreeService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

import javax.servlet.http.HttpServletResponse

import org.springframework.web.bind.annotation.RequestMethod.OPTIONS
import org.springframework.web.bind.annotation.RequestParam

@Controller
class MainController {

    @Autowired
    lateinit var  treeService: TreeService


    @PostMapping(path = arrayOf(Router.BASE_PATH), produces = arrayOf(MediaType.APPLICATION_JSON_VALUE), consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun createTree(@RequestBody dto: ArrayList<Int>): ResponseEntity<*> {

        logger.info("[createTree] POST request arrived to {} with values", BASE_PATH, dto.toString())
        val response: ResponseEntity<*>

        response = try {
             treeService.createBTree( dto)
            logger.info("[createTree] success POST  request  to {} ", BASE_PATH)

            ResponseEntity<Any>( HttpStatus.OK)

        } catch (e: Exception) {
            logger.error("[createTree] error in  POST  request  {} , due to {}", BASE_PATH, e.message, e)
            ResponseEntity<Any>(HttpStatus.INTERNAL_SERVER_ERROR)
        }

        return response
    }

    @GetMapping(path = arrayOf(Router.GET_LCA), produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getLCA(@RequestParam(value = "a") a:Int, @RequestParam(value = "b") b:Int ): ResponseEntity<*> {

        logger.info("[createTree] POST request arrived to {} with values $a,$b", BASE_PATH)
        val response: ResponseEntity<*>

        response = try {
            val responseService = treeService.getLCA( a,b)
            logger.info("[createTree] success POST  request  to {} ", BASE_PATH)

            ResponseEntity<Any>(responseService, HttpStatus.OK)

        } catch (e: Exception) {
            logger.error("[createTree] error in  POST  request  {} , due to {}", BASE_PATH, e.message, e)
            ResponseEntity<Any>(HttpStatus.INTERNAL_SERVER_ERROR)
        }

        return response
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MainController::class.java)
    }

}

data class ElementsDto(
    var elements:ArrayList<Int>
)
