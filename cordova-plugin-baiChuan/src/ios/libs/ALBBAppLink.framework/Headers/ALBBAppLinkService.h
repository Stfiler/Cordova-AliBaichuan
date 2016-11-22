//
//  ALBBAppLinkService.h
//  Linker
//
//  Created by liqing on 16/2/2.
//  Copyright © 2016年 baichuan. All rights reserved.
//

#import <Foundation/Foundation.h>

/** 自定义参数isv_code键 */
extern NSString * const ALBBAppLinkParamISVCode;
/** 自定义参数pid键 */
extern NSString * const ALBBAppLinkParamPID;

/** 手淘跳转服务 */
@protocol ALBBAppLinkService <NSObject>
#pragma mark property
/** 回跳地址 */
@property (nonatomic, copy) NSString *backURL;
/** 淘客ID */
@property (nonatomic, copy) NSString *taokeID;
/** 淘客类型 */
@property (nonatomic, copy) NSString *taokeType;

#pragma mark action
/** 跳转到店铺 */
- (BOOL)jumpShop:(NSString *)shopID;
/** 跳转到店铺 */
- (BOOL)jumpShop:(NSString *)shopID params:(NSDictionary<NSString*, NSString*> *)params;

/** 跳转到详情 */
- (BOOL)jumpDetail:(NSString *)itemID;
/** 跳转到详情 */
- (BOOL)jumpDetail:(NSString *)itemID params:(NSDictionary<NSString*, NSString*> *)params;

/** 跳转到任意淘宝URI */
- (BOOL)jumpTBURI:(NSString *)URI;
/** 跳转到任意淘宝URI */
- (BOOL)jumpTBURI:(NSString *)URI params:(NSDictionary<NSString*, NSString*> *)params;

/**
 跳转到授权页面,授权登录功能仅在可信模式下有效，不可信模式下使用该方法将停留在“淘宝首页”
 授权结果通过block的形式回调3方app，参数为mixedNick、iconURL、error
 */
- (BOOL)doAuth:(NSString *)redirectURI completion:(void (^)(NSError *error, NSDictionary *authInfo))completion;
/**
 跳转到授权页面,授权登录功能仅在可信模式下有效，不可信模式下使用该方法将停留在“淘宝首页”
 授权结果通过block的形式回调3方app，参数为mixedNick、iconURL、error
 */
- (BOOL)doAuth:(NSString *)redirectURI params:(NSDictionary<NSString*, NSString*> *)params completion:(void (^)(NSError *error, NSDictionary *authInfo))completion;
/**
 处理appLink返回结果，需要在AppDelegate的 [application:(UIApplication)app handleOpenURL:(NSURL*)url]中添加
 */
- (BOOL)handleOpenURL:(NSURL *)url;
@end
