Functional requirements:
•             Events should be consumed from Google Calendar (today, volunteer events are on Google Calendar; most volunteer apps have an ability to create events but we really want 1 master source of events).

•             Volunteers set up their profile with name, email, ‘segment’ (youth or adult), your mobile, emergency mobile.

•             Volunteers can look at upcoming events and ‘register’ their intent to come. Nice to give an option to export this event to another calendar they might use. Volunteers be able to see a list of upcoming events they have registered.

•             AAH’s Program Manager should be able to view the list of upcoming events and see who has registered to volunteer so they know how many volunteers to expect (and contact if necessary).

•             Registered volunteers will get reminders.

•             When volunteers arrive, they can ‘check in’ (app should date/time stamp). When volunteers leave, they can ‘check out’ (there should be an ‘hours volunteered’ field that auto calculates checkout time-checkin time but the field can be overridden by the volunteer in case they forgot to checkout and does it later). If the volunteer has not checked out by end of day, then a reminder should be sent to have the volunteer checkout and log the # of hours volunteered.

•             On a daily basis, the volunteer hours (event, volunteer name, email, date, hours) should be available to AAH staff. This can either be via a portal (need export function) or emailed (to peter@aahsmilefarm.org but email address should be configurable) or go directly into Salesforce, our system of record for volunteers. Salesforce also has the ability to create custom tables. So if we have the ability to use Salesforce as our backend database, then I would think that is preferred.



Clarification:
Q: 	Do you wish to update the Google calendar outside the app and have the app update accordingly, or have functionality to update the calendar within the app? I’m open either way but today
A: 	we use Google Calendar and there are actually several people that update the calendar; one of the things we update are the volunteers that signed up for the event (we put in the description field). https://calendar.google.com/calendar/b/1?cid=MWlmbGpxN2loMDFnOGxwZmxjNG91ZmNsMTBAZ3JvdXAuY2FsZW5kYXIuZ29vZ2xlLmNvbQ

Q: 	Will the Program Manager be accessing the "list of upcoming events” solely through the app, or will there be a need for the information to be available via another medium such as a website as well? 
A: 	The program manager accesses the events via our shared Google Calendar, she looks to see how many volunteers she has. But one of our challenges is there are some confidential information we need on the event that only ‘staff’ should see so we actually have a duplicate Google Calendar of events for staff and try to keep the two calendars manually in sync. So if there’s a way to have a single master calendar and control the field display, that would be better.

Q: 	What format is preferred for exported hours? A spreadsheet with rows as events, rows for names and many columns, different spreadsheets for individuals, or some other way to organize it? Another medium entirely? 
A: 	A spreadsheet format would be sufficient. But if we can write directly into Salesforce, that would even be better as I would copy and paste the spreadsheet information into Salesforce to record the volunteer hours.

Q: 	Will the Program Manager be the only administrative account needed, or will there be other positions that need to be able to register for an administrative account as well? 
A: 	There would be other staff members that need ‘admin’ access.

Q: 	Do the reminders need to be customizable or just a standard reminder of the date and time of an event? For example: “Event this Saturday from 1pm-3pm, make sure to bring a pair of gloves and your permission slips!" 
A: 	Standard reminder would be fine. But a ‘nice to have’ feature is the ability for ‘staff’ to send a note to all the volunteers signed up for a given event; it could be a cancellation note, or location change, or something.

Q: 	Where should the email address configuration be located? Maybe in the Program Manager’s account view or configurable via a value in Salesforce?  
A: 	This gets a little sensitive. Email is privacy information. So I don’t want it in the cloud where it could get hacked (we have ~5000 stored emails in Salesforce today and I know Salesforce takes security seriously). But I can’t give everyone a Salesforce user license; I only get 10 free licenses so it’s really only Salesforce ‘admins’ I get accounts to. Also, not everyone that downloads the app may be registered in Salesforce. My current thinking was to have their personal email stored locally on the downloaded app (I don’t even know if you can do this). Even if the user was not registered today, they could download the app, see the events and volunteer. They would record their hours for the event. When I get the spreadsheet and begin entering the hours, if the user was not registered in Salesforce, I would send them an email and ask them to register online (I need them to do this as they need to opt into liability and multimedia releases). Naturally, we could have the app look up the user in Saleforce to see if they exists but I think that would actually be complicated (latency, duplicate names, nicknames, etc).