define({ "api": [
  {
    "type": "post",
    "url": "finduser",
    "title": "Obtiene un usuario",
    "version": "0.1.0",
    "name": "finduser",
    "group": "User",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Number",
            "optional": false,
            "field": "id",
            "description": "<p>ID de usuario a consultar.</p>"
          },
          {
            "group": "Parameter",
            "type": "Number",
            "optional": false,
            "field": "sysUser",
            "description": "<p>Usuario que realiza la consulta.</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Number",
            "optional": false,
            "field": "errorcode",
            "description": "<p>E000</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "errordescription",
            "description": "<p>Success</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Response:",
          "content": "    {\n\"clientid\": 1,\n \"updatedby\": 0,\n \"dateupdated\": \"2017-02-06 11:29:46.0\",\n \"active\": \"Y\",\n \"datecreated\": \"2017-02-06 11:29:46.0\",\n \"chainname\": \"Provecomer\",\n \"uid\": 1,\n \"errordescription\": \"Sucess\",\n \"createdby\": 0,\n \"clientname\": \"Henkel\",\n \"pwdlastset\": \"2017-02-06 11:29:46.0\",\n \"errorcode\": \"E000\",\n \"email\": null,\n \"username\": \"sysUser\"\n    }",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "UserNotFound",
            "description": "<p>The id of the User was not found.</p>"
          },
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "UserInvalid",
            "description": "<p>The id of the User was not found.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "\n{\n  \"error\": \"UserNotFound\"\n}",
          "type": "json"
        },
        {
          "title": "Error-Response:",
          "content": "\n{\n  \"error\": \"UserNotFound\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "classes/UserController.java",
    "groupTitle": "User"
  }
] });
