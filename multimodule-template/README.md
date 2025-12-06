# Multi-Module Tachyon


This project is setup as follows.
* All modules are under the root project dir.
* Each module directory begins with `mod-` followed by its name
* The root project build.sbt only has global settings applicable to all modules.
* Each module has its own build.sbt, with its specific instructions

Reasons for creating modules
* If you have multiple deployable units for the same core.  For example you may create an abstraction layer in core that is wrapped within different rest frameworks.

# Commands
Global commands executed across all modules as follows `sbt fmt`
Server module specific command `sbt docker:publishLocal`  


# References
* [Multi-Module Tachyon](https://github.com/FasterThanLightTech/scala-tachyons/tree/multimodule-tachyon)