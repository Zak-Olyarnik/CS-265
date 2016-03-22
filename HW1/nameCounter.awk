# uses an array to count the occurances of each same hostname
# tolower function enforces case insensitivity
{ Total[tolower($1)] += 1 }

END{
# prints the unique hostnames and their number of occurances
command = "sort -nrk2"	# sorts as desired
n=0							# counter for total number of unique names

for (i in Total)
{
	n=n+1
	print i, " ", Total[i] | command
}
done

# prints total to a temporary text file because trying to print directly
# to screen actually outputs BEFORE the piped loop
print "total ", n > "totalFile.txt"
 
 }



