#!/bin/bash
for file in $(ls .) ; do
	if [ -f  $file ] ; then
      lines=$(wc -l < $file)
      words=$(wc -w < $file)
      echo $file $lines $words
	fi
done

