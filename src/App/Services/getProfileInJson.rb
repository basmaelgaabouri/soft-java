require 'linkedin-scraper'

profile = Linkedin::Profile.new("#{ARGV.first}")
puts profile.to_json
