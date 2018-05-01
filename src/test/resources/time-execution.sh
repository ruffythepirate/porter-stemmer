for ((i = 1; i <= 100; i++)); do
  time cat the-wasteland | java -jar porter-stemmer-assembly-0.0.1.jar &> /dev/null
done 2>&1 | tee timing.log


