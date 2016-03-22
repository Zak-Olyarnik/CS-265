# changes output-field separator 
BEGIN{
		OFS = ""
	  }

# uses an array to count the occurances of each same thread number
{ Total[$1] += $2 }

END{
# finds the largest number of occurances
	most = 0
	for (i in Total)
	 {
	 	if (Total[i] > most)
			most = Total[i]
	 }

# prints out problems with the largest number of occurances
	for (i in Total)
	 {
		if (Total[i] == most)
			print "prob", i, " ", Total[i]
	 }
 }

