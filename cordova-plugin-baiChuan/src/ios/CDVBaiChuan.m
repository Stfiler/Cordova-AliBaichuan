//
//  CDVBaiChuan.m
//  Yingyan
//
//  Created by xudesong on 16/11/21.
//
//

#import "CDVBaiChuan.h"

#import <ALBBAppLink/ALBBSDK.h>
#import <ALBBAppLink/ALBBAppLinkService.h>

@implementation CDVBaiChuan

//  初始化阿里百川
- (void)initAliBaiChuan: (CDVInvokedUrlCommand *)command
{
    [self.commandDelegate runInBackground:^{
        [[ALBBSDK sharedInstance] asyncInit:^{
            CDVPluginResult *result = [CDVPluginResult resultWithStatus: CDVCommandStatus_OK messageAsString: @"success"];
            [self.commandDelegate sendPluginResult: result callbackId: command.callbackId];
        } failedCallback:^(NSError *error) {
            CDVPluginResult *result = [CDVPluginResult resultWithStatus: CDVCommandStatus_ERROR messageAsString: @"fail"];
            [self.commandDelegate sendPluginResult: result callbackId: command.callbackId];
        }];
    }];
}

//  跳转到淘宝店铺
- (void)jumpToShop: (CDVInvokedUrlCommand *)command
{
    [self.commandDelegate runInBackground:^{
        NSString *shop = [command.arguments objectAtIndex: 0];
        
        BOOL canOpen = [ALBBService(ALBBAppLinkService) jumpShop: shop params:@{ALBBAppLinkParamISVCode : @"your code"}];
        
        if (canOpen) {
            CDVPluginResult *result = [CDVPluginResult resultWithStatus: CDVCommandStatus_OK messageAsString: @"success"];
            [self.commandDelegate sendPluginResult: result callbackId: command.callbackId];
        } else {
            CDVPluginResult *result = [CDVPluginResult resultWithStatus: CDVCommandStatus_ERROR messageAsString: @"fail"];
            [self.commandDelegate sendPluginResult: result callbackId: command.callbackId];
        }
    }];
}

//  跳转到商品详情
- (void)jumpToDetail: (CDVInvokedUrlCommand *)command
{
    [self.commandDelegate runInBackground:^{
        NSString *detail = [command.arguments objectAtIndex: 0];
        
        BOOL canOpen = [ALBBService(ALBBAppLinkService) jumpDetail:detail params:@{ALBBAppLinkParamPID : @"your taoke ID"}];
        
        if (canOpen) {
            CDVPluginResult *result = [CDVPluginResult resultWithStatus: CDVCommandStatus_OK messageAsString: @"success"];
            [self.commandDelegate sendPluginResult: result callbackId: command.callbackId];
        } else {
            CDVPluginResult *result = [CDVPluginResult resultWithStatus: CDVCommandStatus_ERROR messageAsString: @"fail"];
            [self.commandDelegate sendPluginResult: result callbackId: command.callbackId];
        }
    }];
}

//  跳转到淘宝链接
- (void)jumpToURL: (CDVInvokedUrlCommand *)command
{
    [self.commandDelegate runInBackground:^{
        NSString *url = [command.arguments objectAtIndex: 0];
        
       BOOL canOpen = [ALBBService(ALBBAppLinkService) jumpTBURI: url];
        if (canOpen) {
            CDVPluginResult *result = [CDVPluginResult resultWithStatus: CDVCommandStatus_OK messageAsString: @"success"];
            [self.commandDelegate sendPluginResult: result callbackId: command.callbackId];
        } else {
            CDVPluginResult *result = [CDVPluginResult resultWithStatus: CDVCommandStatus_ERROR messageAsString: @"fail"];
            [self.commandDelegate sendPluginResult: result callbackId: command.callbackId];
        }
    }];
}

@end
