;This file will be executed next to the application bundle image
;I.e. current directory will contain folder Bitzec with application files
[Setup]
AppId={{fxApplication}}
AppName=Bitzec
AppVersion=1.0.1
AppVerName=Bitzec 1.0.1
AppPublisher=Zel Technologies GmbH
AppComments=Bitzec
AppCopyright=Copyright (C) 2018
;AppPublisherURL=http://java.com/
;AppSupportURL=http://java.com/
;AppUpdatesURL=http://java.com/
DefaultDirName={pf}\Bitzec
DisableStartupPrompt=Yes
DisableDirPage=No
DisableProgramGroupPage=Yes
DisableReadyPage=No
DisableFinishedPage=No
DisableWelcomePage=Yes
DefaultGroupName=Zel Technologies GmbH
;Optional License
LicenseFile=
;WinXP or above
MinVersion=0,5.1 
OutputBaseFilename=Bitzec-1.0.1
Compression=lzma
SolidCompression=yes
PrivilegesRequired=poweruser
SetupIconFile=Bitzec\Bitzec.ico
UninstallDisplayIcon={app}\Bitzec.ico
UninstallDisplayName=Bitzec
WizardImageStretch=No
WizardSmallImageFile=Bitzec-setup-icon.bmp   
ArchitecturesInstallIn64BitMode=x64
VersionInfoVersion=1.0.1


[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Files]
Source: "Bitzec\Bitzec.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "Bitzec\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{group}\Bitzec"; Filename: "{app}\Bitzec.exe"; IconFilename: "{app}\Bitzec.ico"; Check: returnTrue()
Name: "{commondesktop}\Bitzec"; Filename: "{app}\Bitzec.exe";  IconFilename: "{app}\Bitzec.ico"; Check: returnFalse()


[Run]
Filename: "{app}\Bitzec.exe"; Parameters: "-Xappcds:generatecache"; Check: returnFalse()
Filename: "{app}\Bitzec.exe"; Description: "{cm:LaunchProgram,Bitzec}"; Flags: nowait postinstall skipifsilent; Check: returnTrue()
Filename: "{app}\Bitzec.exe"; Parameters: "-install -svcName ""Bitzec"" -svcDesc ""Bitzec"" -mainExe ""Bitzec.exe""  "; Check: returnFalse()

[UninstallRun]
Filename: "{app}\Bitzec.exe "; Parameters: "-uninstall -svcName Bitzec -stopOnUninstall"; Check: returnFalse()

[Code]
function returnTrue(): Boolean;
begin
  Result := True;
end;

function returnFalse(): Boolean;
begin
  Result := False;
end;

function InitializeSetup(): Boolean;
begin
// Possible future improvements:
//   if version less or same => just launch app
//   if upgrade => check if same app is running and wait for it to exit
//   Add pack200/unpack200 support? 
  Result := True;
end;  
