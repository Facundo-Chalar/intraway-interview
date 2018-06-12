'use strict';

describe('myApp.fizzView module', function() {

  beforeEach(module('myApp.fizzView'));

  describe('fizzView controller', function(){

    it('should be defined', inject(function($controller) {
      var fizzViewCtrl = $controller('fizzViewController');
      expect(fizzViewCtrl).toBeDefined();
    }));

    it('should call endpoint and get correct response', inject(function($controller) {
      var fizzViewCtrl = $controller('fizzViewController');
      expect(fizzViewCtrl).toBeDefined();
    }));

  });
});