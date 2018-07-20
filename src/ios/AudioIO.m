#import "AudioIO.h"
#import <AudioToolbox/AudioToolbox.h>
#import <AVFoundation/AVFoundation.h>

@implementation AudioIO

- (void)enableSpeaker:(CDVInvokedUrlCommand*)command
{

    NSString* enabled = [command.arguments objectAtIndex:0];
    NSError* error;

    AVAudioSession* session = [AVAudioSession sharedInstance];

    [session setActive: YES error: nil];
    [session setCategory:AVAudioSessionCategoryPlayAndRecord error:nil];

    if (enabled) {
        [session overrideOutputAudioPort:AVAudioSessionPortOverrideSpeaker error:&error];
    } else  {
        [session overrideOutputAudioPort:AVAudioSessionPortOverrideNone error:&error];
    } 

}

- (void)setMicrophoneMute:(CDVInvokedUrlCommand*)command
{

    NSString* mute = [command.arguments objectAtIndex:0];
    NSError* error;

    AVAudioSession* session = [AVAudioSession sharedInstance];

    [session setActive: YES error: nil];
    [session setCategory:AVAudioSessionCategoryPlayAndRecord error:nil];

    if (mute) {
        [session setInputGain:0.0 error:&error];
    } else  {
        [session setInputGain:1.0 error:&error];
    } 

}




@end
