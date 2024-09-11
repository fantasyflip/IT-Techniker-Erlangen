# ATTENTION: Open in PowerShell ISE Only! VS-Code can't work with ANSI-Encoding of ps1 file. φ,δ,ό and ί will be misinterpreted in VS-Code!

# Import CSV file .\users.csv

$users = Import-Csv C:\Users\ETAdmin\Documents\Repositories\IT-Techniker-Erlangen\24-25\BSA\CsvImport\users.csv -Delimiter ';' -Encoding UTF8

# Set default Password

$defaultPassword = "Start12345!" | ConvertTo-SecureString -AsPlainText -Force

# Create users imaginary using WhatIf

foreach ($user in $users) {
    
    $name = $user.Spieler_Name

    # check if user has Γ¶, Γ¤, ΓΌ, Γ in name and replace it with oe, ae, ue, ss
    if($name -match "[φόδί]") {
        $name = $name -replace "φ", "oe"
        $name = $name -replace "δ", "ae"
        $name = $name -replace "ό", "ue"
        $name = $name -replace "ί", "ss"
    }

    # Limit username to max 20 characters
    $username = $name.Substring(0, [Math]::Min($user.Spieler_Name.Length, 20))
    New-LocalUser -FullName $user.Spieler_Name -Name $username -Password $defaultPassword -WhatIf
}