$referenceFile = "C:\Users\ETAdmin\Documents\Repositories\IT-Techniker-Erlangen\23-24\BSA\Powershell\ForEach\Dokumente\Zugriffsdummy.txt"

$directory = Get-Item $referenceFile | Select-Object -ExpandProperty DirectoryName

$acl = Get-Acl $referenceFile

$files = Get-ChildItem -Path $directory -File

foreach ($file in $files) {
    if ($file.FullName -ne $referenceFile) {
        Set-Acl -Path $file.FullName -AclObject $acl
        Write-Host "ACL von $referenceFile zu $file kopiert."
    }
}

Write-Host "Berechtigungsvorgang beendet."
