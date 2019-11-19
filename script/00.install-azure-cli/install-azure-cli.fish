#!/usr/bin/env fish

function brew_install
  argparse -n run_docker 'h/help' 'v/version' 'c/cli' -- $argv
  or return 1

  if set -lq _flag_help
    echo "00.install-azure.fish -c"
    return
  end

  if set -lq _flag_version
    echo "versin: 0.0.1"
    return
  end

  if set -lq _flag_cli
    brew update & brew install azure-cli
  end
  echo "00.install-azure.fish -c"
end

brew_install $argv
