# Import CSV file .\users.csv

$users = Import-Csv .\users.csv -Delimiter ';' -Encoding UTF8

# Set default Password

$defaultPassword = "Start12345!" | ConvertTo-SecureString -AsPlainText -Force

# Create users imaginary using WhatIf

foreach ($user in $users) {
    # Limit username to max 20 characters
    $username = $user.Spieler_Name.Substring(0, [Math]::Min($user.Spieler_Name.Length, 20))
    New-LocalUser -FullName $user.Spieler_Name -Name $username -Password $defaultPassword -WhatIf
}