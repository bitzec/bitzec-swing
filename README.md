# [BitzecSwing Wallet]
##  

BitzecSwing Wallet is a GUI destkop wallet for Bitzec. This fully compatible sapling release is availalbe for macOS, Windows and Linux. Download the latest release from GitHub releases or head on to [BitzecSwing Wallet ]  .

![Screenshot](https://github.com/bitzec/bitzec-swing/blob/master/docs/zecmate.png "Main Window")


 ## Building, installing and running the Bitzec Swing Wallet

Before installing the Bitzec-Swing Wallet you need to have Bitzec up and running. The following



1. Operating system and tools


   ```
     sudo add-apt-repository ppa:webupd8team/java
     sudo apt update
     sudo apt install oracle-java8-installer
     sudo apt install oracle-java8-set-default
   ```
   For RedHat/CentOS/Fedora-type Linux systems the command is (like):
   ```
     sudo yum install java-1.8.0-openjdk git ant
   ```


2. Building from source code

   As a start you need to clone the  swing-wallet Git repository:
   ```
    git clone https://github.com/bitzec/bitzec-swing.git
   ```
    cd Bitzec-swing/
   
   ```
    Issue the build command:
   ```
   ant -buildfile ./src/build/build.xml
   ```
   This takes a few seconds and when it finishes, it builds a JAR file `./build/jars/Bitzzec.jar`.
   You need to make this file executable:
   ```
   chmod u+x ./build/jars/Bitzec.jar
   ```
   At this point the build process is finished the built GUI wallet program is the JAR
   file `./build/jars/Bitzec.jar`. In addition the JAR file
   `bitcoinj-core-0.14.5.jar` is also necessary to run the wallet.

3. Installing the built Bitzec Swing

   3.1. If you have built Bitzec from source code:
    copy the Bitzec.jar to  /home/user/bitzec/src` (the same dir. that contains `bitzec-cli` and `bitzecd`). Example copy command:
      ```
    cp -R -v ./build/jars/* ~/bitzec/src    
      ```

4. Running the installed Bitzec Swing

   It may be run from command line or started from another GUI tool (e.g. file manager).
   Assuming you have already installed [Zcash]and the GUI Wallet `Bitzec.jar` in
   directory `/home/user/zcash/src` one way to run it from command line is:
   ```
   java -jar /home/user/bitzec/src/Bitzec.jar
   ```
 or right click and run as java
   ```

### License
This program is distributed under an [MIT License](https://github.com/ZECmate/ZECmate-swing-wallet/raw/master/LICENSE).

### Disclaimer
