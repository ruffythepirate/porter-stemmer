rm $2
for ((i = 1; i <= 10; i++)); do
  time cat the-wasteland | $1 > /dev/null
done 2>&1 | tee $2 > /dev/null
