//
//  ALBBSDK.h
//  Linker
//
//  Created by liqing on 16/2/2.
//  Copyright © 2016年 baichuan. All rights reserved.
//

#import <Foundation/Foundation.h>

#ifndef ALBBService
#define ALBBService(P) ((id<P>)([[ALBBSDK sharedInstance] getService:@protocol(P)]))
#endif

/** SDK */
@interface ALBBSDK : NSObject
/** 共享实例 */
+ (instancetype)sharedInstance;
/** 初始化 */
- (void)asyncInit:(void (^)())onSuccess failedCallback:(void (^)(NSError *))onFailure;
/** 获取服务 */
- (id)getService:(Protocol *)protocol;
@end
