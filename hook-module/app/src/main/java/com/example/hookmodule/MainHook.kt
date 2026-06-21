package com.example.hookmodule

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

class MainHook : IXposedHookLoadPackage {
    companion object {
        private const val TAG = "LSPatchHook"
        private const val TARGET_PACKAGE = "com.example.testapp"
    }

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        if (lpparam.packageName != TARGET_PACKAGE) return

        XposedBridge.log("[$TAG] 成功注入目标应用: ${lpparam.packageName}")

        try {
            XposedHelpers.findAndHookMethod(
                "com.example.testapp.MainActivity",
                lpparam.classLoader,
                "getMessage",
                object : XC_MethodHook() {
                    override fun beforeHookedMethod(param: MethodHookParam) {
                        XposedBridge.log("[$TAG] getMessage() 被拦截，准备修改返回值")
                        // 修改返回值
                        param.result = "我是被 Hook 修改后的消息！LSPatch 工作正常！"
                    }

                    override fun afterHookedMethod(param: MethodHookParam) {
                        XposedBridge.log("[$TAG] getMessage() 执行完毕，返回值: ${param.result}")
                    }
                }
            )
            XposedBridge.log("[$TAG] Hook 设置成功！")
        } catch (e: Throwable) {
            XposedBridge.log("[$TAG] Hook 设置失败: ${e.message}")
            e.printStackTrace()
        }
    }
}
