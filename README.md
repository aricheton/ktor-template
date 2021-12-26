# ktor-template
## Setup
### KLint
#### Idea
Project is using [KLint](https://github.com/pinterest/ktlint) + [klint-gradle](https://github.com/jlleitschuh/ktlint-gradle)
Gradle tasks:
```bash
# apply to project
./gradlew ktlintApplyToIdea
# apply to ide globally
./gradlew ktlintApplyToIdeaGlobally
# apply to git hooks
./gradlew addKtlintCheckGitPreCommitHook
./gradlew addKtlintFormatGitPreCommitHook
```

## Usage

## TODO
- [x] Create logging plugin
- [x] Create dagger plugin
- [ ] Bootstrap Ktor
- [ ] Dependency Injection?
- [ ] Document
  - [ ] Gradle tasks
  - [ ] Project architecture (hexagonal)
  - [ ] Gradle plugins
