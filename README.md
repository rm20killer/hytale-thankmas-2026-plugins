# Hytale Thankmas 2026

Monorepo for Hytale Thankmas 2026 plugins, managed with [Hygradle](https://github.com/ginco-org/hygradle).

## Prerequisites

You need JDK 25, plus lefthook, ktfmt, and commitlint for git hooks. The Gradle wrapper (`./gradlew`) handles Gradle itself.

```bash
./gradlew build      # compile all plugins
./gradlew runAllMods  # start dev server with all plugins loaded
```

**With Nix** (optional): `nix develop` or `direnv allow` provides JDK 25, Gradle, ktfmt, commitlint, and lefthook in a single shell. Lefthook installs git hooks on entry; run `lefthook install` manually if you skip the flake.

## Project structure

```
├── plugins/
│   ├── plugin-one/        # PluginOne
│   │   ├── build.gradle.kts
│   │   └── src/main/kotlin/com/hytalethankmas/pluginone/
│   └── plugin-two/        # PluginTwo
│       ├── build.gradle.kts
│       └── src/main/kotlin/com/hytalethankmas/plugintwo/
├── build.gradle.kts       # root — hygradle.workspace
├── settings.gradle.kts    # includes all :plugins:* subprojects
├── lefthook.yml           # pre-commit (ktfmt) + commit-msg (commitlint)
└── flake.nix              # Nix dev shell with JDK 25, Gradle, ktfmt, commitlint
```

## Adding a plugin

1. Copy an existing plugin directory as a template:

   ```bash
   cp -r plugins/plugin-one plugins/my-plugin
   ```

2. Update `plugins/my-plugin/build.gradle.kts` — change `name`, `mainClass`, and `description`.
3. Rename/move the Kotlin source to match the new package and class name.
4. Add to `settings.gradle.kts`:

   ```kotlin
   include(":plugins:plugin-one", ":plugins:plugin-two", ":plugins:my-plugin")
   ```

   The workspace plugin auto-detects all subprojects with `gg.ginco.hygradle` applied — no `modProjects` override needed.

## Git conventions

[Conventional Commits](https://www.conventionalcommits.org/) enforced by `commitlint` (hook + CI):

```
<type>(<scope>): <lowercase subject>
```

Types: `feat`, `fix`, `docs`, `style`, `refactor`, `perf`, `test`, `chore`, `ci`, `build`, `revert`.

## CI

[`.github/workflows/ci.yml`](.github/workflows/ci.yml) runs on push/PR to `main`:

| Job | Checks |
|---|---|
| `build` | `./gradlew build` |
| `commitlint` | commit message convention |
| `fmt` | `ktfmt --kotlinlang-style` on all `.kt` files |
