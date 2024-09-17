# Read user input for goal count player must have scored
$goalCount = Read-Host "Enter the minimum number of goals the player must have scored"

# Import CSV file
$users = Import-Csv C:\Users\ETAdmin\Documents\Repositories\IT-Techniker-Erlangen\24-25\BSA\CsvImport\users.csv -Delimiter ';' -Encoding UTF8

foreach($user in $users) {
    # Check if the player has scored at least the specified number of goals
    if ($user.Tore -eq $goalCount) {
        # Find all uppercase letters and their indices
        $matches = [regex]::Matches($user.Spieler_Name, "[A-Z]")

        # Ensure there are at least two uppercase letters before proceeding
        if ($matches.Count -ge 2) {
            # Get the index of the second uppercase letter
            $secondUppercaseIndex = $matches[1].Index

            # Split Spieler_Name into Vorname and Nachname
            $firstName = $user.Spieler_Name.Substring(0, $secondUppercaseIndex)
            $lastName = $user.Spieler_Name.Substring($secondUppercaseIndex)

            # Print Vorname, Nachname, Spiele, Tore
            Write-Host "Name:" $firstName $lastName ", Spiele:" $user.Spiele ", Tore" $user.Tore
        } else {
            # Handle cases where the name does not contain enough uppercase letters
            Write-Host "Name:" $user.Spieler_Name ", Spiele:" $user.Spiele ", Tore" $user.Tore
        }
    }
}