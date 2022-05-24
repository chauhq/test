# Ignore inline messages which lay outside a diff's range of PR
github.dismiss_out_of_range_messages

# Sometimes it's a README fix, or something like that - which isn't relevant for
# including in a project's CHANGELOG for example
declared_trivial = github.pr_title.include? "#trivial"

# Make it more obvious that a PR is a work in progress and shouldn't be merged yet
warn("PR is classed as Work in Progress") if github.pr_title.include? "[WIP]"

# Warn when there is a big PR
warn("Big PR") if git.lines_of_code > 2

# Don't let testing shortcuts get into master by accident
fail("fdescribe left in tests") if `grep -r fdescribe specs/ `.length > 1
fail("fit left in tests") if `grep -r fit specs/ `.length > 1

# Android Lint
LINT_OUTPUTS = "**/app/build/reports/lint-results.xml"
Dir[LINT_OUTPUTS].each do |file_name|
  android_lint.skip_gradle_task = true
  android_lint.filtering = true
  android_lint.report_file = "/app/build/reports/lint-results.xml"
  android_lint.lint(inline_mode: true)
end

Dir.glob("./app/build/test-results/**/*.xml").each do |test|
  junit.parse test
  junit.report
end


warn(File.read('ROOM_CHECK_FAILURE')) if File.exist? 'ROOM_CHECK_FAILURE'
