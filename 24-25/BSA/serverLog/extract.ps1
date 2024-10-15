# Read .\server.log line by line
$serverLog = Get-Content -Path .\server.log

# set the filter
$filter = "error"

# create an array to store the collected items
$collectedItems = @()

foreach($line in $serverLog){
    # Check if the line contains the filter
    if($line -match $filter){

        # add to the collected items
        $collectedItems += $line
        
        # get the date using "\d{4}-\d{2}-\d{2}"
        $date = [regex]::Match($line, "\d{4}-\d{2}-\d{2}").Value

        # get everything after the last ']'
        $message = $line -replace ".*\] "

        Write-Host "Datum: "$date", Meldung: "$message
    }
}

# Export the errors to a log file
$collectedItems | Out-File -FilePath .\$filter.log