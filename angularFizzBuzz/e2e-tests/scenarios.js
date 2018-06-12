'use strict';

/* https://github.com/angular/protractor/blob/master/docs/toc.md */

describe('my app', function() {


  it('should automatically redirect to /fizzView when location hash/fragment is empty', function() {
    browser.get('index.html');
    expect(browser.getLocationAbsUrl()).toMatch("/fizzView");
  });


  describe('fizzView', function() {

    beforeEach(function() {
      browser.get('index.html#!/fizzView');
    });


    it('should have min value field present', function(){
      expect(element(by.model('minValue')).isPresent()).toBe(true);
    })

    it('should have max value field present', function(){
      expect(element(by.model('maxValue')).isPresent()).toBe(true);
    })

  });
});
