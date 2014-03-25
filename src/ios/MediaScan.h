//
//  MediaScan.h
//  MediaScan PhoneGap/Cordova plugin

#import <Cordova/CDVPlugin.h>

@interface MediaScan : CDVPlugin
{
	NSString* callbackId;
}

@property (nonatomic, copy) NSString* callbackId;

- (void)file:(CDVInvokedUrlCommand*)command;

@end
