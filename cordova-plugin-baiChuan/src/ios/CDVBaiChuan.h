//
//  CDVBaiChuan.h
//  Yingyan
//
//  Created by xudesong on 16/11/21.
//
//

#import <Cordova/CDVPlugin.h>
#import <Cordova/CDV.h>


@interface CDVBaiChuan : CDVPlugin

//  初始化阿里百川
- (void)initAliBaiChuan: (CDVInvokedUrlCommand *)command;

//  跳转到淘宝店铺
- (void)jumpToShop: (CDVInvokedUrlCommand *)command;

//  跳转到商品详情
- (void)jumpToDetail: (CDVInvokedUrlCommand *)command;

//  跳转到淘宝链接
- (void)jumpToURL: (CDVInvokedUrlCommand *)command;


@end
