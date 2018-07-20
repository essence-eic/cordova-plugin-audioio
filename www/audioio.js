/*global cordova, module*/

module.exports = {
  enableSpeaker: function(on) {
    cordova.exec(null, null, 'AudioIO', 'enableSpeaker', [on]);
  },
  setMicrophoneMute: function(on) {
    cordova.exec(null, null, 'AudioIO', 'setMicrophoneMute', [on]);
  }
};
