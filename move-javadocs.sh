echo "START move javadocs in place..."
if [ -d "docs/javadocs" ]; then rm -fr docs/javadocs; fi
mv lib/target/apidocs docs/javadocs
echo "DONE moving javadocs in place"
