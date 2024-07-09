$Person = @{}

$InfoKeys = @("Vorname", "Nachname", "Alter", "Wohnort")

# Loop over info types and ask for input. Store input in hashtable
foreach ($InfoKey in $InfoKeys) {
    $Person[$InfoKey] = Read-Host "Please enter your $InfoKey"
}

# Print out the hashtable
$Person
