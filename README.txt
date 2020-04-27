SimpleSimon building guide

OVERVIEW
-----------------------------------------------------------------
This guide contains information and instructions required to build and run SimpleSimon application that is provided in Java samples directory.

There are two Android projects in this directory:
	cookiebar2-aar
		Android library that must be built and protected before building SimpleSimon application. Guide covers two ways of library protection: plugin based protection and post build protection.
	SimpleSimon-apk
		Android application that uses protected Android library.



GETTING STARTED
-----------------------------------------------------------------

Before building anything, there must first be set such installation locations:
	1. GuardIT for Java location - set as an environment variable named G4J_HOME. Path must point to root location of installation.
	2. Android SDK location:
		for plugin based protection - can be set either as an environment variable named ANDROID_HOME or in local.properties file (inside cookiebar2-aar directory) by setting variable named sdk.dir (e.g. sdk.dir=C:\Android\Sdk).

		for post build protection - can be set either as an environment variable named ANDROID_HOME or passed as a parameter --sdkdir (e.g. --sdkdir "C:\Android\Sdk")

		Locations must point to the root of SDK location.

	3. Java SDK location - set as an environment variable named JAVA_HOME that points to root of Java SDK



BUILDING AAR
-----------------------------------------------------------------
Using plugin based protection:
	1. navigate to SimpleSimon\cookiebar2-aar, and execute ".\gradlew.bat clean assembleDebug". Command will clean directory from previous build output and will make a fresh debugging enabled build of AAR which will be protected and will have it's finalizer plugin generated.
	2. after build is complete, navigate to SimpleSimon\cookiebar2-aar\cookiebar2\build\outputs\aar\ and move "cookiebar2-debug.aar", "cookiebar2-debug-finalize.jar" ("cookiebar2-debug-finalize.jar" might not exist, depends on your Guardspec) files to SimpleSimon-apk\app\libs


Using post build protection:
	1. navigate to SimpleSimon\cookiebar2-aar, and execute ".\gradlew.bat clean assembleUnprotected". Command will clean directory from previous build output and will make a fresh build of AAR which will be unprotected
	2. after building finishes, head to SimpleSimon\cookiebar2-aar\cookiebar2\build\outputs\aar\ and rename "cookiebar2-unprotected.aar" to "cookiebar2-debug.aar" (this is optional but if the renaming is not performed AAR and finalizer will be named differently from what is specified in application's build.gradle file so the change will be required there)
	3. using console of your choice call guardit4jaar.bat with following parameters:
		* --input - path to AAR that was just built
		* --guard-spec - path to Guardspec named "guardspec-postBuild.gsml". File can be found inside SimpleSimon\cookiebar2-aar\cookiebar2\
		* --output - directory of your choice that will contain protection output
        * --requires-finalization - produces unfinalized library and generates a finalizer plugin
		* --dependency-file - path to file that defines dependencies. File can be found in SimpleSimon\cookiebar2-aar\cookiebar2\ directory under name "dependencies.txt"
		* (optional) --verbose - if specified, prints what parameters guardit4j.bat is called with

		Sample call to guardit4jaar.bat file -
			.\guardit4jaar.bat --input "C:\GuardIT4Java\examples\java\SimpleSimon\cookiebar2-aar\cookiebar2\build\outputs\aar\cookiebar2-debug.aar" --guard-spec "C:\GuardIT4Java\examples\java\SimpleSimon\cookiebar2-aar\cookiebar2\guardspec-postBuild.gsml" --output "C:\protection-output" --requires-finalization --dependency-file "C:\GuardIT4Java\examples\java\SimpleSimon\cookiebar2-aar\cookiebar2\dependencies.txt" --verbose



BUILDING APPLICATION
-----------------------------------------------------------------
1. after AAR is built, navigate to directory that you specified as protection output and copy protected AAR and finalizer JAR to SimpleSimon\SimpleSimon-apk\app\libs directory (before copying you may need to create the SimpleSimon\SimpleSimon-apk\app\libs directory)
2. navigate to SimpleSimon\SimpleSimon-apk
3. using console of your choice run command ".\gradlew.bat clean build". Command will clean directory from previous build output and will make a fresh build of application that uses protected AAR.
4. built application can be found in SimpleSimon\SimpleSimon-apk\app\build\outputs\apk\debug\. Application can now be installed