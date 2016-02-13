/**
 * Jasmine spec file for helloWorld.js.
 */

describe("helloWorld.js: Hello, world!", function() {
  it("Should return 'Hello, world!'", function() {
    expect(mainApp.helloWorld()).toEqual("Hello, world!");
  });
});

describe("helloWorld.js:  Hello, foobar!", function() {
  it("Should return 'Hello, foobar!'", function() {
    expect(mainApp.helloFoobar()).toEqual("Hello, foobar!");
  });
});

describe("helloWorld.js:  Hello, qwerty!", function() {
  it("Should return 'Hello, qwerty!'", function() {
    expect(mainApp.helloQwerty()).toEqual("Hello, qwerty!");
  });
});
