#import <Cordova/CDV.h>

@interface AudioIO : CDVPlugin 

- (void) enableSpeaker:(CDVInvokedUrlCommand*)command;
- (void) setMicrophoneMute:(CDVInvokedUrlCommand*)command;

@end