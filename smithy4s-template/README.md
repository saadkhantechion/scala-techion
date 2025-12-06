# basic-tachyons

This is a basic scala template starter. It has setup for scalafmt and scalafix plugins with sample config files.

## ScalaFmt
Plugin URL : https://scalameta.org/scalafmt/
```shell
sbt scalafmtAll
sbt scalafmtCheckAll
```

## ScalaFix
Plugin URL : https://scalacenter.github.io/scalafix/
```shell
sbt scalafixAll
sbt "scalafixAll --check"
```

## Update Plugin
Use this plugin to find new versions for your dependencies.    
Plugin URL : https://github.com/rtimush/sbt-updates
```shell
sbt dependencyUpdates
```

## Zerowaste Plugin
This plugin will detect unused val
Plugin URL : https://github.com/ghik/zerowaste 


## Scalac Options Plugin
Plugin URL : https://github.com/typelevel/sbt-tpolecat
```shell
# you may want to enable this env var during development, but not CI.
export SBT_TPOLECAT_DEV=true
sbt compile
```

## Aliases
To run both scala fmt and fix together you can do 
```shell
sbt fmt
sbt fmtc
```