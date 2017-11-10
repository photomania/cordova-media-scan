//
//  MediaScan.m
//  MediaScan PhoneGap/Cordova plugin

#import "MediaScan.h"
#import <Cordova/CDV.h>

@implementation MediaScan
@synthesize callbackId;

- (void)file:(CDVInvokedUrlCommand*)command {
    self.callbackId = command.callbackId;

    NSURL *imageURL = [NSURL URLWithString:[command.arguments objectAtIndex:0]];
    NSData *imageData = [NSData dataWithContentsOfURL:imageURL];
    UIImage *image = [UIImage imageWithData:imageData];

    UIImageWriteToSavedPhotosAlbum(image, self, @selector(image:didFinishSavingWithError:contextInfo:), nil);
}

- (void)image:(UIImage *)image didFinishSavingWithError:(NSError *)error contextInfo:(void *)contextInfo {
    CDVPluginResult *pluginResult;

    if (error != NULL) {
        pluginResult = [CDVPluginResult resultWithStatus: CDVCommandStatus_ERROR messageAsString:error.description];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus: CDVCommandStatus_OK messageAsString:@"Image saved"];
    }

    [self.commandDelegate sendPluginResult:pluginResult callbackId:self.callbackId];
}

@end
