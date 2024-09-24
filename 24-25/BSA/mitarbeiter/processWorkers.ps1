# Import CSV file .\mitarbeiter.csv
$workers = Import-Csv C:\Users\ETAdmin\Documents\Repositories\IT-Techniker-Erlangen\24-25\BSA\mitarbeiter\mitarbeiter.csv -Delimiter ',' -Encoding UTF8

# Worker consists of ID, Vorname, Nachname, Abteilung, Gehalt

# Find the worker with the highest Gehalt
$highestSalaryWorker = $workers | Sort-Object -Property gehalt -Descending | Select-Object -First 1

# Display only vorname, nachname, and gehalt
Write-Host
Write-Host "Worker with highest salary: $($highestSalaryWorker.Vorname) $($highestSalaryWorker.Nachname) with salary $($highestSalaryWorker.Gehalt)"
Write-Host

# Display all workers that work in the IT department
$itWorkers = $workers | Where-Object { $_.Abteilung -eq "IT" }

Write-Host "Workers in IT department:"
foreach ($itWorker in $itWorkers) {
    Write-Host "$($itWorker.Vorname) $($itWorker.Nachname)"
}
Write-Host

# Get all workers from Vertrieb department
$salesWorkers = $workers | Where-Object { $_.Abteilung -eq "Vertrieb" }

# Export all workers from Vertrieb department to CSV file named "gefilterte_mitarbeiter.csv"
$salesWorkers | Export-Csv -Path ".\gefilterte_mitarbeiter.csv" -Delimiter ',' -Encoding UTF8 -NoTypeInformation

# Calculate the average salary of all workers
$averageSalary = ($workers | Measure-Object -Property gehalt -Average).Average

Write-Host "Average salary of all workers: $averageSalary"
Write-Host
