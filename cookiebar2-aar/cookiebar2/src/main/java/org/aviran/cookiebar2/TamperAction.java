package org.aviran.cookiebar2;

import android.util.Log;

public class TamperAction {

    public static void tamperDynamicInstrumentationDetectionGuard() {
        Log.e("AAR", "DynamicInstrumentationDetectionGuard: Tampering detected");
    }

    public static void nonTamperDynamicInstrumentationDetectionGuard() {
        Log.e("AAR", "DynamicInstrumentationDetectionGuard: Tampering not detected");
    }

    public static void tamperRootDetectionGuard() {
        Log.e("AAR", "RootDetectionGuard: Tampering detected");
    }

    public static void nonTamperRootDetectionGuard() {
        Log.e("AAR", "RootDetectionGuard: Tampering not detected");
    }

    public static void tamperHookDetectionGuard() {
        Log.e("AAR", "HookDetectionGuard: Tampering detected");
    }

    public static void nonTamperHookDetectionGuard() {
        Log.e("AAR", "HookDetectionGuard: Tampering not detected");
    }

    public static void tamperEmulatorDetectionGuard() {
        Log.e("AAR", "EmulatorDetectionGuard: Emulator detected");
    }

    public static void nonTamperEmulatorDetectionGuard() {
        Log.e("AAR", "EmulatorDetectionGuard: Emulator not detected");
    }

    public static void tamperDebuggerDetectionGuard() {
        Log.e("AAR", "DebuggerDetectionGuard: Tampering detected");
    }

    public static void nonTamperDebuggerDetectionGuard() {
        Log.e("AAR", "DebuggerDetectionGuard: Tampering not detected");
    }

    public static void tamperChecksumGuard() {
        Log.e("AAR", "ChecksumGuard: Tampering detected");
    }

    public static void nonTamperChecksumGuard() {
        Log.e("AAR", "ChecksumGuard: Tampering not detected");
    }

    public static void tamperResourceVerificationGuard() {
        Log.e("AAR", "ResourceVerificationGuard: Tampering detected");
    }

    public static void nonTamperResourceVerificationGuard() {
        Log.e("AAR", "ResourceVerificationGuard: Tampering not detected");
    }
}
