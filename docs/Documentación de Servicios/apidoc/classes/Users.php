<?php
class Users
{

	public function __construct()
	{

	}

	/**
	 * @api {get} /user/:id Obtiene la información de un usuario - prueba
	 * @apiVersion 0.1.0
	 * @apiName GetUser
	 * @apiGroup User
	 *
	 * @apiParam {Number} id Users unique ID.
	 *
	 * @apiSuccess {Number} code  Código 0 conforme todo ha ido bien.
	 * @apiSuccess {Bool} true/false  True o false dependiendo del resultado.
	 *
	 * @apiSuccessExample Success-Response:
	 *     HTTP/1.1 200 OK
	 *     {
	 *       "code": 0,
	 *       "response": true
	 *     }
	 *
	 * @apiError UserNotFound The id of the User was not found.
	 *
	 * @apiErrorExample Error-Response:
	 *     HTTP/1.1 404 Not Found
	 *     {
	 *       "error": "UserNotFound"
	 *     }
	 */
	public function get()
	{

	}

	/**
	 * @api {post} /user Crea un usuario
	 * @apiVersion 0.1.0
	 * @apiName PostUser
	 * @apiGroup User
	 *
	 * @apiSuccess {Number} code  Código 0 conforme todo ha ido bien.
	 * @apiSuccess {Nuumber} userId   Id del usuario registrado.
	 *
	 * @apiSuccessExample Success-Response:
	 *     HTTP/1.1 200 OK
	 *     {
	 *        "code": 0,
	 *        "response": userId
	 *     }
	 *
	 * @apiError UserBadResponse El usuario no ha podido crearse
	 *
	 * @apiError BaD-Response:
	 *     HTTP/1.1 400 Bad Response
	 *     {
	 *       "error": "BadResponse"
	 *     }
	 */
	public function create()
	{

	}

	/**
	 * @api {put} /user/:id Actualiza la información de un usuario
	 * @apiVersion 0.1.0
	 * @apiName PutUser
	 * @apiGroup User
	 *
	 * @apiParam {Number} id Users unique ID.
	 *
	 * @apiSuccess {Number} code  Código 0 conforme todo ha ido bien.
	 * @apiSuccess {Bool} true/false True o false dependiendo del resultado.
	 *
	 * @apiSuccessExample Success-Response:
	 *     HTTP/1.1 200 OK
	 *     {
	 *       "code": 0,
	 *       "response": true
	 *     }
	 *
	 * @apiError UserNotFound The id of the User was not found.
	 *
	 * @apiErrorExample Error-Response:
	 *     HTTP/1.1 404 Not Found
	 *     {
	 *       "error": "UserNotFound"
	 *     }
	 */
	public function update()
	{

	}

	/**
	 * @api {delete} /user/:id Elimina un usuario
	 * @apiVersion 0.1.0
	 * @apiName DeleteUser
	 * @apiGroup User
	 *
	 * @apiParam {Number} id Users unique ID.
	 *
	 * @apiSuccess {Number} code  Código 0 conforme todo ha ido bien.
	 * @apiSuccess {Bool} true/false True o false dependiendo del resultado.
	 *
	 * @apiSuccessExample Success-Response:
	 *     HTTP/1.1 200 OK
	 *     {
	 *       "code": 0,
	 *       "response": true
	 *     }
	 *
	 * @apiError UserNotFound The id of the User was not found.
	 *
	 * @apiErrorExample Error-Response:
	 *     HTTP/1.1 404 Not Found
	 *     {
	 *       "error": "UserNotFound"
	 *     }
	 */
	public function delete()
	{

	}
}