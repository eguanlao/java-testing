
var mainApp = {};

(function(mainApp, $, undefined) {

  mainApp.helloFoobar = function() {
    return "Hello, foobar!";
  };

  mainApp.helloQwerty = function() {
    return "Hello, qwerty!";
  };

  mainApp.helloWorld = function() {
    return "Hello, world!";
  };

}(mainApp, jQuery));

$(document).ready(function () {

  console.log(mainApp.helloWorld());
  console.log(mainApp.helloFoobar());
  console.log(mainApp.helloQwerty());

});
