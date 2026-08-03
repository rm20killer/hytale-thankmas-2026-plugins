{
  description = "Hytale Thankmas 2026 - monorepo dev environment";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = nixpkgs.legacyPackages.${system};
      in
      {
        devShells.default = pkgs.mkShell {
          name = "thankmas-dev";

          packages = with pkgs; [
            jdk25
            gradle
            kotlin-language-server
            ktfmt
            lefthook
            commitlint
          ];

          JAVA_HOME = pkgs.jdk25.home;

          shellHook = ''
            lefthook install
          '';
        };
      }
    );
}
