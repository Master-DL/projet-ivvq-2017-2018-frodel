define({ "api": [
  {
    "type": "post",
    "url": "/travel/",
    "title": "",
    "name": "addTravel",
    "group": "Travel",
    "description": "<p>Add a travel</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>The name of travel</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Travel",
            "optional": false,
            "field": "travel",
            "description": "<p>The new travel</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/TravelController.java",
    "groupTitle": "Travel"
  },
  {
    "type": "post",
    "url": "/inscriptions/",
    "title": "",
    "name": "addUser",
    "group": "User",
    "description": "<p>Add an user</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "pseudo",
            "description": "<p>The pseudo of new user</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "mdp",
            "description": "<p>The password of new user</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "email",
            "description": "<p>The email of new user</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "User",
            "optional": false,
            "field": "utilisateur",
            "description": "<p>The new user</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/UserController.java",
    "groupTitle": "User"
  },
  {
    "type": "delete",
    "url": "/inscriptions/:userId",
    "title": "",
    "name": "deleteUser",
    "group": "User",
    "description": "<p>Delete an user</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Long",
            "optional": false,
            "field": "userId",
            "description": "<p>The id of user to delete</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./src/main/java/com/frodel/controller/UserController.java",
    "groupTitle": "User"
  }
] });
