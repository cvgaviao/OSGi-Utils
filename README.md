#OSGi Utilities

##The Goal

Nowadays I'm working a lot with OSGi, more precisally with Equinox. And I'm using two tools to build my projects: Eclipse Tycho for manifes-first projects and Maven Bundle Plugin for pom-first projects. 

It is not possible to build both types same time using tycho. It must be done in two steps always. 

So, to help me I've decided to create one P2 Repository and concentrate there the most important bundles that I'm using, grouped by features, including already OSGi and OSGified ones.

This way all other projects can be setup a Target Platform Definition pointing to it and only use Tycho for the building.

The P2 was categorized in two type: OSGi Utils, that contains utilities made by myself or based in somebody work and Dependencies, that is basically a repackaging of already existent bundles.

##Building the P2 Repository

This build will create a P2 repository at directory "OSGi-Utils/com.c4biz.osgiutils.p2/target/repository" that contains all features needed by EPF to be installed as plugins.

### Using a OS terminal console

1) Clone the repository

 	git clone git@github.com:cvgaviao/OSGi-Utils.git       

2) Go to the OSGi-Utils parent directory and call the maven command

	cd OSGi-Utils/
	mvn clean verify -P p2-all 

### Using Eclpse IDE Launcher

If you want you can import the projects into Eclipse and build them using the supplied launcher. You must ensure that you have installes the latest m2e plugin and its tycho add-on.

1) Import the project using 'Existing Maven Projects' 

2) Go to 'Run Configurations' and select "OSGi Utilities - P2".

