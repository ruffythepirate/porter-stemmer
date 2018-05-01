cat $1 | grep user | grep -oP \[\\d.\]\+s | sed 's/s//' | perl average.pl 
